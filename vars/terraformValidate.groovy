def call() {
    sh '''
        terraform init -backend=false
        terraform validate
    '''
}
