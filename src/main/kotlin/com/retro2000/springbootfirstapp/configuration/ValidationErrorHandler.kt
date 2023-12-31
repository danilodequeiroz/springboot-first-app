package com.retro2000.springbootfirstapp.configuration

import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@Suppress(UNUSED)
@RestControllerAdvice
class ValidationErrorHandler {

    @Autowired
    lateinit var messageSource: MessageSource

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): MutableList<KeyedByFieldError> {
        val errors = mutableListOf<KeyedByFieldError>()
        val fieldErrors: MutableList<FieldError> = exception.bindingResult.fieldErrors
        fieldErrors.forEach { e ->
            val error = KeyedByFieldError(
                e.field, messageSource.getMessage(
                    e, LocaleContextHolder.getLocale()
                )
            )
            errors.add(error)
        }
        return errors
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(exception: ConstraintViolationException): MutableList<GenericError> {
        val errors = mutableListOf<GenericError>()
        val fieldErrors: MutableSet<ConstraintViolation<*>> = exception.constraintViolations
        fieldErrors.forEach { error ->
            errors.add(
                when (error.propertyPath.firstOrNull()) {
                    null -> GenericError(error.propertyPath.first().name)
                    else -> KeyedByFieldError(error.propertyPath.firstOrNull()?.name.toString(), error.message)
                }
            )
        }
        return errors
    }
}