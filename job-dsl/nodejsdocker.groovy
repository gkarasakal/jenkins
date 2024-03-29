job('NodeJS_Docker_example') {
    scm {
        git('https://github.com/gkarasakal/docker_demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('gkarasakal')
            node / gitConfigEmail('gokhankarasakal@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('gkarasakal/jenkins')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
