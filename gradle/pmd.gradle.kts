plugins {
    pmd
}

configure<PmdExtension> {
    ruleSetFiles = files("config/pmd/ruleSets.xml")
}

tasks.withType<Pmd> {
    reports {
        xml.isEnabled = false
        html.isEnabled = true
    }
}
