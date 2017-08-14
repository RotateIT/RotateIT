plugins {
    checkstyle
}

configure<CheckstyleExtension> {
    toolVersion = "8.1"
    maxErrors = Int.MAX_VALUE
}

tasks.withType<Checkstyle> {
    reports {
        xml.isEnabled = false
        html.isEnabled = true
    }
}
