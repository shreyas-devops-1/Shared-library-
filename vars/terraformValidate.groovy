def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'

    dir(workingDir) {

        sh '''
            terraform init -backend=false
            terraform validate
        '''
    }
}
