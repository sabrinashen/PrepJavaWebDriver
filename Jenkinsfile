pipeline {
  agent any
  environment {
    // docker path: /usr/local/bin
    PATH = "$PATH:/usr/local/bin"
  }
  stages {
    stage('docker-compose up') {
      steps {
      	sh 'sudo docker-compose up -d'
      	sh 'sudo docker-compose scale chrome=5'
      	sh 'sudo docker-compose scale firefox=5'
      	sh 'sudo docker ps -a'
      }
    }
      
    stage('run script') {
      steps {
      	parallel(
               "chrome-module":{
               	sh 'mvn clean test -DsuiteXmlFile=chrome_test.xml'
               },
               "firefox-module":{
               	sh 'mvn clean test -DsuiteXmlFile=firefox_test.xml'
               }
        )
      }
    }
  }
  
  post {
	always {
		sh 'echo "selenium grid down"'
		sh 'sudo docker-compose down'
		archiveArtifacts artifacts: 'log/**', fingerprint: true
		archiveArtifacts artifacts: 'test-output/**', fingerprint: true
  	}
  }
}