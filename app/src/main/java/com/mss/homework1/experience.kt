package com.mss.homework1

/**
 * Считается, что в месяце 30 дней, а в году - 365
 * 'd' - день
 * 'm' - месяц
 * 'y' - год
 * Пример: 5d = 5 дней = 5
 *         7y6m20d = 7 лет 6 месяцев 20 дней  ~  StrToDays = 7*365+6*30+20 = 2755
 */
fun ExperienceToDays(s: String): Int {
    var days: Int = 0

    val s = if (s[0] in arrayOf('>', '<')) s.substring(1) else s

    var temp: String = ""
    for (c in s) {
        if (c.isDigit()) temp += c else {
            if (temp.isEmpty()) continue
            when (c) {
                'd' -> days += temp.toInt()
                'm' -> days += temp.toInt() * 30
                'y' -> days += temp.toInt() * 365
            }
            temp = ""
        }
    }

    return days
}

fun ExperienceToRussian(s: String): String {
    var result: String = ""

    var s0: Char = ' '
    val s = if (s[0] in arrayOf('>', '<')) { s0 = s[0]; s.substring(1) } else s

    var temp: String = ""
    for (c in s) {
        if (c.isDigit()) temp += c else {
            if (temp.isEmpty()) continue
            when (c) {
                'd' -> {
                    result +=  "$temp " + when (temp.toInt()) {
                        1, 21, 31 -> if (s0 == ' ') "день" else "дня"
                        2, 3, 4, 22, 23, 24 -> if (s0 == ' ') "дня" else "дней"
                        in 5..20, in 25..30 -> "дней"
                        else -> "d"
                    } + " "
                }
                'm' -> {
                    result +=  "$temp " + when (temp.toInt()) {
                        1 -> if (s0 == ' ') "месяц" else "месяца"
                        2, 3, 4 -> if (s0 == ' ') "месяца" else "месяцев"
                        in 5..12 -> "месяцев"
                        else -> "m"
                    } + " "
                }
                'y' -> {
                    result +=  "$temp " + when (temp.toInt() % 100) {
                        in 5..19 -> "лет"
                        else -> when (temp.toInt() % 10) {
                            1 -> if (s0 == ' ') "год" else "года"
                            2, 3, 4 -> if (s0 == ' ') "года" else "лет"
                            in 5..9, 0 -> "лет"
                            else -> "y"
                        }
                    } + " "
                }
            }
            temp = ""
        }
    }

    return if (s0 != ' ') s0.toString() + result.trimEnd() else result.trimEnd()
}
