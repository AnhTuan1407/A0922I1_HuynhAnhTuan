import {Category} from "./category";

export interface Product {
  id?: number,
  nameProduct?: string,
  category?: Category,
  quantity?: number,
  dateRelease?: string,
  price?: number,
  description?: string
}
