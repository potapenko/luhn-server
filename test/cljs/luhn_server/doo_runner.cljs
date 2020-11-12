(ns luhn-server.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [luhn-server.core-test]))

(doo-tests 'luhn-server.core-test)

