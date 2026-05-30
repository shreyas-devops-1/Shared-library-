def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'

    dir(workingDir) {

        withCredentials([
            usernamePassword(
                credentialsId: 'Github-Token-Shreyas',
                usernameVariable: 'GIT_USER',
                passwordVariable: 'GIT_TOKEN'
            )
        ]) {

            sh '''
                git config --global url."https://${GIT_USER}:${GIT_TOKEN}@github.com/".insteadOf "https://github.com/"

                terraform init -backend=false

                terraform validate
            '''
        }
    }
}
