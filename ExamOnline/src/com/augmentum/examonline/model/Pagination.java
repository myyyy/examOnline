package com.augmentum.examonline.model;

import com.augmentum.examonline.until.PropertiesUtil;


    public class Pagination {
        private static final String KEY_PAGE_SIZE =PropertiesUtil.getProperty("page.size");
        //total of notes in database
        private int totalRecords;

        //one page have pqgeSize data
        private int pageSize;

        //Now web page
        private int pageNo;
        @SuppressWarnings("unused")
        private int offset;

        /**
         * get count page
         * @return
         */

        public int getTotalPages() {
            return (totalRecords + getPageSize() - 1) / getPageSize();
        }
        /**
         * get topPage
         * @return
         */
        public int getTopPageNo() {
            return 1;
        }

        /**
         * PreviousPage
         * @return
         */
        public int getPreviousPageNo() {
            if (pageNo <= 1) {
                return 1;
            }
            return pageNo - 1;
        }

        /**
         * Nextpage
         * @return
         */
        public int getNextPageNo() {
            if (pageNo >= getBottomPageNo()) {
                return getBottomPageNo();
            }
            return pageNo + 1;
        }

        /**
         * last page
         * @return
         */
        public int getBottomPageNo() {
            return (totalRecords + getPageSize() - 1) / getPageSize();
        }
        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getPageSize() {
            if(pageSize == 0){
                String size = KEY_PAGE_SIZE;
                pageSize = Integer.parseInt(size);
            }
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNo() {
            if(pageNo > getTotalPages()){
                pageNo = getTotalPages();
            }
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;

        }
        public int getOffset() {
            return (getPageNo() - 1) * getPageSize();
        }
    }
