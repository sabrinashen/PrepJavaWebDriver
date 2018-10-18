pipeline {
  agent any
  stages {
    stage('docker-compose up') {
      steps {
      	sh 'sudo docker-compose up -d'
      	sh 'sudo docker-compose scale chrome=5'
      	sh 'sudo docker-compose scale chrome=5'
      	sh 'sudo docker ps -a'
      }
    }
      
    stage('run script') {
      steps {
      	parallel(
               "google-module":{
               	sh 'bundle exec parallel_rspec test/google/'
               },
               "baidu-module":{
               	sh 'bundle exec parallel_rspec test/baidu/'
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