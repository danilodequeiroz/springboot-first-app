package com.retro2000.springbootfirstapp.configuration

import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
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
    fun handle(exception: MethodArgumentNotValidException): MutableList<InvalidFields> {
        val errors = mutableListOf<InvalidFields>()
        val fieldErrors: MutableList<FieldError> = exception.bindingResult.fieldErrors
        fieldErrors.forEach { e ->
            val error = InvalidFields(
                e.field, messageSource.getMessage(
                    e, LocaleContextHolder.getLocale()
                )
            )
            errors.add(error)
        }
        return errors
    }
}