#!/usr/bin/env bash
set -e
source .build-config.sh
for FN in ${FN_BUILD}; do
  faas-cli deploy -f "${FN}.yml"
done
