import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Data } from '../data';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Rata } from '../rata';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  constructor(private http: HttpClient) { }

  public calculate(): Observable<Data[]> {
    const result = this.http.get('http://localhost:8080/calculate2?kwota=250000&&okres=180&&marza=3&&wibor=1&&prowizja=1');
    // result.subscribe((r: any) =>
    //   console.log(r[0])
    // );
    return result.pipe(
      map((data: any[]) =>
        data.map(
          (item: any) =>
            this.mapData(item)
        )
      )
    );
  }

  private mapData(item: any): Data {
    const rates = item.raty.map((elem: any) => new Rata(elem.numerRaty, elem.kwota, elem.rataKapitalowa, elem.odsetki));
    return new Data(item.odsetkiCalkowite, item.sumaNadplat, item.kwotaBazowa, item.prowizja, rates);
  }
}
