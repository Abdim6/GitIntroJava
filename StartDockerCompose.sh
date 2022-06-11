#!/bin/bash
echo "Stay Home"
sh "chmod +x -R ${env.WORKSPACE}/../${env.JOB_NAME}@script"
docker-compose up -d 
