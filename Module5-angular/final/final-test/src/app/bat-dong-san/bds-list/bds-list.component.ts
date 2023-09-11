import { Component, OnInit } from '@angular/core';
import {Bds} from "../model/bds";
import {Router} from "@angular/router";
import {BdsService} from "../service/bds/bds.service";
import Swal from "sweetalert2";
@Component({
  selector: 'app-bds-list',
  templateUrl: './bds-list.component.html',
  styleUrls: ['./bds-list.component.css']
})
export class BdsListComponent implements OnInit {

  bdsList: Bds[] = [];
  displayStyle = 'none';
  idBds: number;
  p = 1;
  bds: Bds;

  constructor(private _BdsService: BdsService, private _router: Router) {
  }

  private Swal: any;
  private msg: boolean;

  ngOnInit(): void {
    this._BdsService.getAllBds().subscribe(
      bds => {
        this.bdsList = bds;
        console.log('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }

  // search(inputSearch: HTMLInputElement) {
  //   this._BdsService.search(inputSearch.value).subscribe(next => {
  //     this.bdsList = next;
  //     if (this.bdsList.length === 0) {
  //       this.msg = true;
  //     } else {
  //       this.msg = false;
  //     }
  //   });
  // }

  openPopup(id: number) {
    this.displayStyle = 'block';
    this.idBds = id;
  }

  closePopup() {
    this.displayStyle = 'none';
  }

  searchPrice(inputSearchPrice: HTMLInputElement) {
    this._BdsService.searchPrice(inputSearchPrice.value).subscribe(next => {
      this.bdsList = next;
      if (this.bdsList.length === 0) {
        this.msg = true;
      } else {
        this.msg = false;
      }
    });
  }


  searchHuong(inputSearchHuong: HTMLInputElement) {
    this._BdsService.searchHuong(inputSearchHuong.value).subscribe(next => {
      this.bdsList = next;
      if (this.bdsList.length === 0) {
        this.msg = true;
      } else {
        this.msg = false;
      }
    });
  }

  searchArea(inputSearchArea: HTMLInputElement) {
    this._BdsService.searchArea(inputSearchArea.value).subscribe(next => {
      this.bdsList = next;
      if (this.bdsList.length === 0) {
        this.msg = true;
      } else {
        this.msg = false;
      }
    });
  }

    searchAll(inputArea: HTMLInputElement, inputPrice: HTMLInputElement) {
      if (inputArea.value === '' && inputPrice.value === '') {
        Swal.fire('Vui lòng nhập từ khóa cần tìm kiếm');
      } else {
        this._BdsService.searchAll(inputArea.value, inputPrice.value).subscribe(next => {
          this.bdsList = next;
          if (this.bdsList.length === 0) {
            this.msg = true;
          } else {
            this.msg = false;
          }
        });
      }
    }
  }
