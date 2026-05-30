def call(Map config=[:]) {
    pipeline {
        agent any

        stages {
            stage('FMT') {
                steps {
                    terraformFmt()
                }
            }

            stage('VALIDATE') {
                steps {
                    terraformValidate()
                }
            }

            stage('LINT') {
                steps {
                    terraformLint()
                }
            }

            stage('PLAN') {
                steps {
                    terraformPlan(
                        varFile: config.varFile
                    )
                }
            }
        }
    }
}
