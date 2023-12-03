pluginManagement {
  includeBuild("build-logic")
}

rootProject.name = "template"

sequenceOf("api", "plugin").forEach {
  include("${rootProject.name}-$it")
  project(":${rootProject.name}-$it").projectDir = file(it)
}

/*sequenceOf("v1_17_R1", "v1_20_R1").forEach {
  include("${rootProject.name}-$it")
  project(":${rootProject.name}-$it").projectDir = file("adapt/$it")
}*/
