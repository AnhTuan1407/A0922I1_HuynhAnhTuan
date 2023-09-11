import {Component, OnInit} from '@angular/core';
import {Bds} from "../model/bds";
import {BdsService} from "../service/bds/bds.service";
import {Router} from "@angular/router";
import {HuongService} from "../service/huong/huong.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Huong} from "../model/huong";
import Swal from "sweetalert2";
import {MucDichService} from "../service/muc-dich.service";
import {TinhTrangService} from "../service/tinh-trang.service";
import {VaiTroService} from "../service/vai-tro.service";
import {VungMien} from "../model/vung-mien";
import {VungMienService} from "../service/vung-mien.service";
import {MucDich} from "../model/muc-dich";
import {TinhTrang} from "../model/tinh-trang";
import {VaiTro} from "../model/vai-tro";

@Component({
  selector: 'app-bds-create',
  templateUrl: './bds-create.component.html',
  styleUrls: ['./bds-create.component.css']
})
export class BdsCreateComponent implements OnInit {
  huongList: Huong[];
  mucDichList: MucDich[];
  tinhTrangList: TinhTrang[];
  vaiTroList: VaiTro[];
  vungMienList: VungMien[];

  bdsForm: FormGroup = new FormGroup({
    danhMuc: new FormControl(),
    vungMien: new FormControl(),
    vaiTro: new FormControl(),
    mucDich: new FormControl(),
    tinhTrang: new FormControl(),
    diaChi: new FormControl('', [Validators.required]),
    dienTich: new FormControl('', [Validators.required, Validators.min(20)]),
    huong: new FormControl(),
    tuaDe: new FormControl('', [Validators.required]),
    noiDung: new FormControl('', [Validators.required]),
    gia: new FormControl('', [Validators.required, Validators.min(100000000)]),
    ngayDang: new FormControl(),
  })

  constructor(private _bdsService: BdsService, private _router: Router, private _huongService: HuongService, private _mucDichService: MucDichService, private _tinhTrangService: TinhTrangService, private _vaitroService: VaiTroService, private _vungMien: VungMienService) {
  }

  ngOnInit(): void {
    this._huongService.getAllHuong().subscribe(
      huong => {
        this.huongList = huong;
      }, error => {
        console.log('error');
      }
    )

    this._mucDichService.getAllMucDich().subscribe(
      data => {
        this.mucDichList = data;
      }, error => {
        console.log('error');
      }
    )

    this._tinhTrangService.getAllTinhTrang().subscribe(
      data => {
        this.tinhTrangList = data;
      }, error => {
        console.log('error');
      }
    )

    this._vaitroService.getAllVaiTro().subscribe(
      data => {
        this.vaiTroList = data;
      }, error => {
        console.log('error');
      }
    )

    this._vungMien.getAllVungMien().subscribe(
      data => {
        this.vungMienList = data;
      }, error => {
        console.log('error');
      }
    )
  }

  submit() {
    const product = this.bdsForm.value;
    console.log(product);
    this._bdsService.save(product).subscribe(() => {
        this.bdsForm.reset();
        this._router.navigate(['/bds/list']);
        Swal.fire('Đăng tin thành công');
      }, error => {
        console.log('Error');
        alert('Error');
        console.log(product);
      }
    )
  }

  createBds() {
    const product = this.bdsForm.value;
    console.log(product);
    this._bdsService.save(product).subscribe(() => {
        this.bdsForm.reset();
        this._router.navigate(['/bds/list']);
        Swal.fire('Đăng tin thành công');
      }, error => {
        console.log('Error');
        alert('Error');
        console.log(product);
      }
    )
  }
}
