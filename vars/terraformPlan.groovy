def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'
    String varFile    = config.varFile ?: ''

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
            '''

            sh 'terraform init'

            if (varFile?.trim()) {

                sh """
                    terraform plan -var-file=${varFile}
                """

            } else {

                sh 'terraform plan'
            }
        }
    }
}
