pipeline {
    agent any

    environment {
        IMAGE_NAME = 'chandhankanagaraj/murugar-web'
        REGISTRY_CREDENTIALS = 'dockerhub-creds'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Chandhank/chandhan.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: "$REGISTRY_CREDENTIALS", usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh '''
                    echo "$PASS" | docker login -u "$USER" --password-stdin
                    docker push $IMAGE_NAME
                    '''
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}

