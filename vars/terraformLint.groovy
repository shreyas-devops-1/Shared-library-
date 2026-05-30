def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'

    dir(workingDir) {

        sh 'tflint'
    }
}
