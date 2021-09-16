#!/bin/sh

location=${LOCATION}

option=
for arg in "$@"
do
    key=${arg%%=*}
    value=${arg#*=}
    case $key in
        --location)
            location=$value
        ;;
        *)
            option="$option $key=$value"
        ;;
    esac
done

if [ ! "${location}" ]; then
    echo "location not set!"
    exit 1
fi

echo "LOCATION: ${location}"
echo "TZ: ${TZ}"

wget -O ./application.yml "http://apis.newegg.org/eggkeeper/v2/staffing/${location}/_rawdata"

echo "JAVA_OPTS: ${JAVA_OPTS}"

java ${JAVA_OPTS} -jar app.jar${option}
