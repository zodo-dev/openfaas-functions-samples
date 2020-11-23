#!/usr/bin/env bash
set -e
source .build-config.sh

rm -rf template/quarkus-native
rm -rf template/quarkus-native-slim
faas-cli template pull https://github.com/edimarlnx/openfaas-quarkus-native-template

for FN in ${FN_BUILD}; do
  rm -rf build
  faas-cli build -f "${FN}.yml"
  faas-cli push -f "${FN}.yml"
done
