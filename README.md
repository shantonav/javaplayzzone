# javaplayzzone

to run the email sending test case you would need to pull the postfix docker container 

1. checkout : https://github.com/juanluisbaptiste/docker-postfix
2. CD docker-postfix
3. docker build -t postfix -f Dockerfile .
4. Comment the below lines in run.sh
  `#[ -z "${SMTP_USERNAME}" ] && echo "SMTP_USERNAME is not set" && exit 1   # [ -z "${SMTP_PASSWORD}" ] && echo "SMTP_PASSWORD is not set" && exit 1`
5. Export the below properties 
`export SMTP=172.30.1.10
export SMTP_SERVER=172.30.1.10
export SMTP_PORT=587
export SMTP_HOSTNAME=172.30.1.10
`
6. Docker run `docker run -it --name postfix -p 2525:25 -e SMTP_SERVER="${SMTP}" -e SMTP_USERNAME='' -e SMTP_PASSWORD= -e SERVER_HOSTNAME=my.local -e TX_SMTP_RELAY_HOST="${SMTP}" -e TX_SMTP_RELAY_MYHOSTNAME=my.local -e TX_SMTP_RELAY_USERNAME=${USERNAME} -e TX_SMTP_RELAY_PASSWORD=${PASSWORD} -e TX_SMTP_RELAY_NETWORKS=${TX_SMTP_RELAY_NETWORKS} --rm postfix`
