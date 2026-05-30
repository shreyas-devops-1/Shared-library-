def call(Map config = [:]) {

    stage('FMT') {

        terraformFmt(
            workingDir: config.workingDir
        )
    }

    stage('VALIDATE') {

        terraformValidate(
            workingDir: config.workingDir
        )
    }

    stage('LINT') {

        terraformLint(
            workingDir: config.workingDir
        )
    }

    stage('PLAN') {

        terraformPlan(
            workingDir: config.workingDir,
            varFile: config.varFile
        )
    }
}
