plugins {
  id("project.base-conventions")
}

dependencies {
  api(project(":${rootProject.name}-api"))
}