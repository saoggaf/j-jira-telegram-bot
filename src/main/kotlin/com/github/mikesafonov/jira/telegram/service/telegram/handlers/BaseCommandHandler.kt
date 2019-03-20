package com.github.mikesafonov.jira.telegram.service.telegram.handlers

import com.github.mikesafonov.jira.telegram.dao.State
import com.github.mikesafonov.jira.telegram.service.telegram.TelegramCommand

/**
 * @author Mike Safonov
 */
abstract class BaseCommandHandler : TelegramCommandHandler {

    protected fun isChatExist(command: TelegramCommand): Boolean {
        return command.chat != null
    }

    protected fun isInState(command: TelegramCommand, state: State): Boolean {
        return isChatExist(command) && command.chat!!.state == state
    }

    protected fun isMatchText(command: TelegramCommand, text : String) : Boolean {
        return command.hasText && command.text == text
    }

    protected fun isStartsWithText(command: TelegramCommand, text : String) : Boolean {
        return command.hasText && command.text!!.startsWith(text)
    }
}