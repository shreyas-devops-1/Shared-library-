def call() {
    sh 'terraform fmt -check -recursive'
}
