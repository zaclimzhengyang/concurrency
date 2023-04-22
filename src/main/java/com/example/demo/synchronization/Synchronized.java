package com.example.demo.synchronization;

import java.util.ArrayList;

public class Synchronized {

    /**
     *  locks and thread synchronization
     *
     * `synchronized` keyword acts as a lock to protect certain parts of the code to be executed by several
     * threads at the same time
     *
     * it ensures:
     *      1. that only a single thread can execute a block of code at the same time
     *      2. that each thread entering a synchornized block of code sees the effects of all previous
     *      modifications that were guarded by the same lock
     *      3. that another thread which is calling this method would wait until the first thread leaves this method
     *
     */

    public synchronized void criticalMethod() {

    }

    public class CrawledSites {
        private ArrayList<String> crawledSites = new ArrayList<String>();
        private ArrayList<String> linkedSites = new ArrayList<String>();

        // keep track of the visited sites and
        // keeps a list of sites which needs to be crawled

        /**
         * synchronised(this) {
         *     crawledSitesObject.add(site);
         * }
         */

        public void add(String site) {
            synchronized (this) {
                if (!crawledSites.contains(site)) {
                    linkedSites.add(site);
                }
            }
        }

        // get next site to crawl.
        // return null if nothing else to crawl
        public String next() {
            if (linkedSites.size() == 0) {
                return null;
            }
            synchronized (this) {
                // need to check again if size has changed
                if (linkedSites.size() > 0) {
                    String s = linkedSites.get(0);
                    linkedSites.remove(0);
                    crawledSites.add(s);
                    return s;
                }
                return null;
            }
        }
    }
}
