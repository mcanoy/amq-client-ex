URL accessible at <context>/amq.html. sends message to amq broker


## To deploy in openshift:

```oc new-app jboss-webserver31-tomcat8-openshift:1.1~git@zurich-gitlab.gitlab-z.svc.cluster.local:zurich-labs/amq-client-ex.git --source-secret=git-key```


- Remember to deploy the source secret defined in the IAC repo
