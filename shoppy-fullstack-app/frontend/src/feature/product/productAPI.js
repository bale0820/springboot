import React from 'react';
import { createProduct, filterProduct } from './productSlice.js';
import { axiosData, groupByRows, axiosGet, axiosPost } from '../../utils/dataFetch.js';

/**
    상품 QnA
*/
export const getQna = async(pid) => {

//즉, Axios가 undefined를 null로 바꾸는 게 아니라
//undefined는 JSON에서 사라져버리는 것이에요.
    const url = "/product/qna";
    console.log('pid', pid);
    const qna = await axiosPost(url, {"pid" : pid});
    console.log('qna', qna);
//    const list = JSON.parse(info.list);
    return qna;
    }



/**
    상품 상세 정보
*/
export const getDetailinfo = async(pid) => {
    const url = "/product/detailinfo";
    const info = await axiosPost(url, {"pid" : pid});
//    console.log("detailinfo==>", detailinfo);
    const list = JSON.parse(info.list);
    return {...info, list : list};
//    dispatch(filterProduct({"product" : product}));
}


export const getProduct = (pid) => async(dispatch) => {
    // dispatch(filterProduct(pid));

    const url = "/product/pid";
    const product = await axiosPost(url, {"pid" : pid});
    console.log("product--->",product);
    dispatch(filterProduct({"product" : product}));
}

export const getProductList = (number) => async(dispatch) => {
//    const jsonData = await axiosData("/data/products.json");
    const url = "/product/all";
    const jsonData = await axiosGet(url);
    console.log('jsonData-->', jsonData);
    const rows = groupByRows(jsonData, number);
    dispatch(createProduct({"productList": rows, "products":jsonData}));
}

