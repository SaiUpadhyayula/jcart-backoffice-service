pipeline {
     agent any
     stages {
          stage("Compile") {
               steps {
                    sh "./gradlew compile"
               }
          }
          stage("Unit test") {
               steps {
                    sh "./gradlew test"
               }
          }
     }
}
