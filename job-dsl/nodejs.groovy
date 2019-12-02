job('NodeJS_example') {
    scm {
        git('https://github.com/gkarasakal/jenkins.git') {  node -> // is hudson.plugins.git.GitSCM
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
        shell("npm install")
    }
}
