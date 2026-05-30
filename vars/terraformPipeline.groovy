def call(Map config=[:]) {

    stage('FMT') {
        terraformFmt()
    }

    stage('VALIDATE') {
        terraformValidate()
    }

    stage('LINT') {
        terraformLint()
    }

    stage('PLAN') {
        terraformPlan(
            varFile: config.varFile
        )
    }
}
