package com.mss.homework1

/**
 * Считается, что в месяце 30 дней, а в году - 365
 * 'd' - день
 * 'm' - месяц
 * 'y' - год
 * Пример: 5d = 5 дней = 5
 *         7y6m20d = 7 лет 6 месяцев 20 дней  ~  StrToDays = 7*365+6*30+20 = 2755
 * Если есть символ >/<, тогда к числу +/- 1 день.
 * Пример: <1y = <1 года = 365-1 = 364
 *         >1y = >1 года = 365+1 = 366
 * @param condition - открючает +/- от символов >/<
 */
fun experienceToDays(s_: String, condition: Boolean = false): Int {
    var days: Int = 0

    /*var s: String = if (condition) // Это должно было работать, но оно почему-то не работает...
        if (s[0] in arrayOf('>', '<')) s.substring(1) else s
    else
        when (s[0]) {
            '<' -> { days = -1; s.substring(1); }
            '>' -> { days = 1; s.substring(1); }
            else -> s
        }*/

    var s: String = ""
    if (condition)
        s = if (s_[0] in arrayOf('>', '<')) s_.substring(1) else s_
    else
        when (s_[0]) {
            '<' -> { s = s_.substring(1); days = -1 }
            '>' -> { s = s_.substring(1); days = 1 }
            else -> s = s_
        }

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

fun experienceToRussian(s: String): String {
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
