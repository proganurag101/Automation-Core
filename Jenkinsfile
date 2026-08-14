pipeline {
    agent any

    /* 
     * Optional: If Maven, JDK, or Allure Commandline are configured in your Jenkins Global Tool Configuration
     * (Manage Jenkins -> Tools), you can uncomment and adjust the names below:
     *
     * tools {
     *     maven 'Maven'
     *     jdk 'JDK_17'
     * }
     */

    parameters {
        string(
            name: 'TEST_RUNNER',
            defaultValue: 'ApiRunner',
            description: 'Name of the Test Runner class to execute (default: ApiRunner)'
        )
    }

    environment {
        MAVEN_OPTS = '-Dfile.encoding=UTF-8'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                echo 'Checking out source code from SCM...'
                checkout scm
            }
        }

        stage('Run API Tests') {
            steps {
                script {
                    echo "Executing API Tests using runner: ${params.TEST_RUNNER}"

                    // Cross-platform command execution for Windows and Linux/macOS nodes
                    if (isUnix()) {
                        sh "mvn clean test -Dtest=${params.TEST_RUNNER}"
                    } else {
                        bat "mvn clean test -Dtest=${params.TEST_RUNNER}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Processing test results and archiving reports...'

            // 1. Publish surefire JUnit XML test results in Jenkins UI
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true

            // 2. Archive Cucumber HTML Report as build artifact
            archiveArtifacts artifacts: 'target/cucumber-reports.html', allowEmptyArchive: true

            // 3. Generate and publish Allure Report (requires Allure Jenkins Plugin)
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
        success {
            echo 'Pipeline execution finished successfully!'
        }
        failure {
            echo 'Pipeline execution failed! Check test reports and logs for details.'
        }
    }
}
