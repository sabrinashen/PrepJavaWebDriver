pipeline {
  agent any
  environment {
    // docker path: /usr/local/bin
    PATH = "$PATH:/usr/local/bin"
  }
  stages {
    stage('docker-compose up') {
      steps {
      	sh 'sudo docker-compose down'
      	sh 'sudo docker-compose up -d'
      	sh 'sudo docker-compose scale chrome=5'
      	sh 'sudo docker-compose scale firefox=5'
      	sh 'sudo docker ps -a'
      }
    }
    
    stage('maven clean') {
    	steps {
    		sh 'mvn clean'
    	}
    }
      
//    stage('run script') {
//      steps {
//      	parallel(
//               "chrome-module":{
//               	sh 'mvn test -DsuiteXmlFile=chrome_test.xml'
//               },
//               "firefox-module":{
//               	sh 'mvn test -DsuiteXmlFile=firefox_test.xml'
//               }
//        )
//      }
//    }
//  }
  
  	stage('run script') {
      steps {
      	sh 'mvn test -DsuiteXmlFile1=chrome_test.xml -DsuiteXmlFile2=firefox_test.xml'
      }
    }
  }
  
  post {
	always {
		sh 'echo "selenium grid down"'
		sh 'sudo docker-compose down'
		archiveArtifacts artifacts: 'target/surefire-reports/**', 'log/*.log', 'log/screenshot/*.png', fingerprint: true
  	}
  }
}