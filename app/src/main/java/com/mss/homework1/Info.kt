package com.mss.homework1

class User(val name: String, val grade: String, val link: String)
class Project(val info: String)
class SkillsHeader
class Skill(val name: String, val experience: String)

class FilterItem(
    var experience: String,
    var value: Boolean = true
) {
    val text get() = experienceToRussian(experience)
}
