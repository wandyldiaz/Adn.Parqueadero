pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave4_Mac'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8' //Preinstalada en la Configuración del Master
    gradle 'Gradle4.5' //Preinstalada en la Configuración del Master
    
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
            $class: 'GitSCM',
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [],
            gitTool: 'Default',
            submoduleCfg: [],
            userRemoteConfigs: [[
                credentialsId: 'GitHub_wandyldiaz',
                url:'https://github.com/wandyldiaz/Adn.Parqueadero'
            ]]
        ])

      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
        sh 'gradle --b ./build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Analisis de codigo estatico<------------'
       withSonarQubeEnv('Sonar') {
       sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
       }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        //Construir sin tarea test que se ejecutó previamente
        sh 'gradle --b ./build.gradle build -x test'

      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      failure {
      echo 'This will run only if failed'
      mail (to: 'wandyl.diaz@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
      }
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
