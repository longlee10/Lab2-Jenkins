pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'MAVEN3'
        jdk 'JDK'
    }

    stages {
        stage('Checkout & Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/longlee10/Lab2-Jenkins.git'

                // To run Maven on a Windows agent, use
                bat 'mvn -Dmaven.test.failure.ignore=true clean compile'
            }
        }

        // stage('Code Coverage') {
        //     steps {
        //         // use Jacoco to generate code coverage report
        //         bat 'mvn clean test jacoco:report'
        //     }
        // }

        // stage('Add Dockerhub password to Jenkins') {
        //     steps {
        //         withCredentials([usernamePassword(credentialsId: 'Docker-hub')]) {
        //             // do something with the credentials
        //             bat 'docker login -u longquan98 -p $Long98docker'
        //         }
        //     }
        // }

        stage('Docker build') {
            steps {
                // build the docker image
                bat 'docker build -t longquan98/maven .'
            }
        }

        stage('Docker login') {
            steps {
                bat 'docker login -u longquan98 -p "Long98docker"'
            }
        }

        stage('Docker push') {
            steps {
                // push the docker image to docker hub
                bat 'docker push longquan98/maven'
            }
        }
    }
}
