def call(Map config=[:]) {
    sh """
        terraform init
        terraform plan -var-file=${config.varFile}
    """
}
