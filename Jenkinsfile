pipeline {
  agent any
  tools {
    maven "Apache Maven 3.8.5" }
  stages {
    stage ('Build') {
      steps {
          dir("/Users/abdi.bileh17/Documents/Java/monTest") {
        sh "pwd"
        sh 'mvn test -P Docker'
  }}}
      
      stage ('Deploy') {
      steps {
        script {
          echo 'Tout va bien !'}
      }
  }}
}
				
				
				
				
				
				
				
				
				
				
