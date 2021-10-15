plugins {
   id("com.palantir.docker") version "0.30.0"
}

version = "1.0.0-SNAPSHOT"

tasks.register("prepareDocker") {
	// doFirst {
	// 	copy {
    //         from("$buildDir/libs")
    //         include("*.war")
    //         into("$buildDir/docker/build/libs/")
    //     }
    // }
    // shouldRunAfter("dbTest")
    project.logger.lifecycle("pushing docker image figker/${project.name}:${project.version}")
}

docker {
    dependsOn(tasks.getByName("prepareDocker"))
    name="figker/${project.name}:${project.version}"
    tag("-version", "figker/${project.name}:${project.version}")
    tag("-latest", "figker/${project.name}:latest")
    tag("-SNAPSHOT", "figker/${project.name}:SNAPSHOT")
    copySpec.from("src/main/resources").into("config")
    noCache to "true"
}
