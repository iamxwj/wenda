//package com.wd.utils;
//
//import com.wd.domain.InstitutionInfoEntity;
//import com.wd.domain.InvestorInfoEntity;
//import com.wd.domain.es.InstitutionDocument;
//import com.wd.domain.es.InvestorDocument;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Zhipeng
// * @date 2016/6/17.
// */
//public class EntityDocumentConvertor {
//    /**
//     * render  InstitutionInfoEntity
//     *
//     * @param infoEntity
//     * @return
//     */
//    public static InstitutionDocument renderInstitution(InstitutionInfoEntity infoEntity) {
//        List<InvestorInfoEntity> list =  infoEntity.getMemberEntityList();
//        return new InstitutionDocument(infoEntity.getInstitutionName(), infoEntity.getInstitutionId(), renderInstitutionMemberToString(list));
//    }
//
//    public static Iterable<InstitutionDocument> renderInstitutions(Iterable<InstitutionInfoEntity> infos) {
//        List<InstitutionDocument> documents = new ArrayList<>();
//        for (InstitutionInfoEntity info : infos) {
//            documents.add(renderInstitution(info));
//        }
//        return documents;
//    }
//
//    public static List<String> renderInstitutionMemberToString(Iterable<InvestorInfoEntity> memberEntityList) {
//        List<String> string = new ArrayList<>();
//        for (InvestorInfoEntity member : memberEntityList) {
//            string.add(member.getInvestorName());
//        }
//        return string;
//    }
//
//    public static Iterable<Long> getInstitutionIds(Iterable<InstitutionDocument> institutionDocuments) {
//        List<Long> ids = new ArrayList<>();
//        for (InstitutionDocument institutionDocument : institutionDocuments) {
//            ids.add(institutionDocument.getInstitutionId());
//        }
//        return ids;
//    }
//
//
//    // end of render InstitutionInfoEntity
//
//    //start of render Investor
//    public static Iterable<InvestorDocument> renderInvestor(Iterable<InvestorInfoEntity> all) {
//        List<InvestorDocument> investors = new ArrayList<>();
//        for (InvestorInfoEntity i : all) {
//            investors.add(renderInvestor(i));
//        }
//        return investors;
//    }
//
//    public static InvestorDocument renderInvestor(InvestorInfoEntity i) {
//        return new InvestorDocument(i.getInvestorId(), i.getInvestorName(), i.getInstitutionName(), i.getInvestorPosition());
//    }
//
//    public static Iterable<Long> getInvestorIds(Iterable<InvestorDocument> all){
//        List<Long> ids = new ArrayList<>();
//        for(InvestorDocument i: all){
//            ids.add(i.getInvestorId());
//        }
//        return ids;
//    }
//    // end of the Investor
//}
