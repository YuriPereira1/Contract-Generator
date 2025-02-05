plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.apache.poi:poi-ooxml:5.2.5")
    implementation("org.apache.logging.log4j:log4j-core:2.22.1")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("org.javatuples:javatuples:1.2")

}

tasks.test {
    useJUnitPlatform()
}