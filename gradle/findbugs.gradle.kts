plugins {
    findbugs
}

tasks.withType<FindBugs> {
    reports {
        xml.isEnabled = false
        html.isEnabled = true
    }
}
