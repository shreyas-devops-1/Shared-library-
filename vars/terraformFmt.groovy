def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'

    dir(workingDir) {

        sh 'terraform fmt -check -recursive'
    }
}
