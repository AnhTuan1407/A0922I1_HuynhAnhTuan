import {Huong} from "./huong";
import {VaiTro} from "./vai-tro";
import {VungMien} from "./vung-mien";
import {MucDich} from "./muc-dich";
import {TinhTrang} from "./tinh-trang";

export interface Bds {
  id: number
  danhMuc: string,
  vungMien: VungMien,
  vaiTro: VaiTro,
  mucDich: MucDich,
  tinhTrang: TinhTrang,
  diaChi: string,
  dienTich: number,
  huong: Huong;
  tuaDe: string,
  noiDung: string,
  gia: number,
  ngayDang: string,
}
