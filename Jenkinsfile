pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Checkout source code from your version control system
                git 'https://github.com/longlee10/Lab2-Jenkins.git'
                
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
    }
}