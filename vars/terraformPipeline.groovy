def call(Map config = [:]) {

    String workingDir = config.workingDir ?: '.'
    String varFile    = config.varFile ?: ''

    dir(workingDir) {

        sh 'terraform init'

        if (varFile?.trim()) {

            sh """
                terraform plan \
                -var-file=${varFile}
            """

        } else {

            sh 'terraform plan'

        }
    }
}
