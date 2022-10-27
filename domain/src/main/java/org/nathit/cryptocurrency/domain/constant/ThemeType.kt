package org.nathit.cryptocurrency.domain.constant

import org.nathit.cryptocurrency.domain.R


enum class ThemeType(val id: Int, val nameRes: Int) {
    THEME_LIGHT(0, R.string.light_mode),
    THEME_DARK(1,R.string.night_mode)
}